package com.richchau.nfldashboard.data;

import javax.sql.DataSource;

import com.richchau.nfldashboard.model.Game;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final String[] FIELD_NAMES = new String[] { "id", "schedule_date", "schedule_season", "schedule_week",
            "schedule_playoff", "team_home", "score_home", "score_away", "team_away", "team_favorite_id",
            "spread_favorite", "over_under_line", "stadium" };

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<GameInput> reader() {
        return new FlatFileItemReaderBuilder<GameInput>().name("GameItemReader")
                .resource(new ClassPathResource("games.csv")).delimited().names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<GameInput>() {
                    {
                        setTargetType(GameInput.class);
                    }
                }).build();
    }

    @Bean
    public GameDataProcessor processor() {
        return new GameDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Game> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Game>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO game (id, schedule_date, schedule_season, schedule_week, schedule_playoff, team_home, score_home, score_away, team_away, team_favorite_id, spread_favorite, over_under_line, stadium) VALUES (:id, :scheduleDate, :scheduleSeason, :scheduleWeek, :schedulePlayoff, :teamHome, :scoreHome, :scoreAway, :teamAway, :teamFavoriteId, :spreadFavorite, :overUnderLine, :stadium)")
                .dataSource(dataSource).build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
                .end().build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Game> writer) {
        return stepBuilderFactory.get("step1").<GameInput, Game>chunk(10).reader(reader()).processor(processor())
                .writer(writer).build();
    }

}
