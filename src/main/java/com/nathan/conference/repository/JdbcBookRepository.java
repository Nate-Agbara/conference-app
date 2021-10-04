package com.nathan.conference.repository;

import com.nathan.conference.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBookRepository implements RegistrationRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from guest", Integer.class);
    }

    @Override
    public int save(Registration registration) {
        return jdbcTemplate.update(
                "insert into guest (name, email) values(?,?)",
                registration.getName(), registration.getEmail());
    }

    @Override
    public int update(Registration registration) {
        return jdbcTemplate.update(
                "update guest set name = ? where id = ?",
                registration.getName(), registration.getEmail());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete guest where id = ?",
                id);
    }

    @Override
    public List<Registration> findAll() {
        return jdbcTemplate.query(
                "select * from guest",
                (rs, rowNum) -> {
                    Registration registration = new Registration();
                    registration.setId(rs.getInt("id"));
                    registration.setName(rs.getString("name"));
                    registration.setEmail(rs.getString("email"));
                    return registration;
                });
    }

    // jdbcTemplate.queryForObject, populates a single object
//    public Optional<Registration> findById(Integer id) {
//        return jdbcTemplate.queryForObject(
//                "select * from guest where id = ?",
//                new Object[]{id},
//                (rs, rowNum) -> {
//                    Registration registration = new Registration();
//                        Optional.of(
//                                registration.setId(rs.getInt("id"));
//                                registration.setName(rs.getString("name"));
//                                registration.setEmail(rs.getString("email"));
//                                return registration;
//                        )}
//        );
//    }

    @Override
    public List<Registration> findByNameAndEmail(String name, String email) {
        return jdbcTemplate.query(
                "select * from guest where name like ? and email <= ?",
                new Object[]{"%" + name + "%", email},
                (rs, rowNum) -> {
                    Registration registration = new Registration();
                    registration.setId(rs.getInt("id"));
                    registration.setName(rs.getString("name"));
                    registration.setEmail(rs.getString("email"));
                    return registration;
                });
    }

    @Override
    public String getNameById(int id) {
        return jdbcTemplate.queryForObject(
                "select name from guest where id = ?",
                new Object[]{id},
                String.class
        );
    }


}
