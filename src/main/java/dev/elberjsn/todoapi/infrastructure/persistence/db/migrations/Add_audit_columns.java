package dev.elberjsn.todoapi.infrastructure.persistence.db.migrations;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Add_audit_columns extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                new SingleConnectionDataSource(context.getConnection(), true)
        );

        jdbcTemplate.execute("""
            DO $$ 
            BEGIN
                IF NOT EXISTS (SELECT 1 FROM information_schema.columns 
                              WHERE table_name = 'persons' AND column_name = 'created_by') THEN
                    ALTER TABLE person ADD COLUMN created_by VARCHAR(100);
                END IF;
                
                IF NOT EXISTS (SELECT 1 FROM information_schema.columns 
                              WHERE table_name = 'persons' AND column_name = 'updated_by') THEN
                    ALTER TABLE person ADD COLUMN updated_by VARCHAR(100);
                END IF;
            END $$;
        """);
    }
}

