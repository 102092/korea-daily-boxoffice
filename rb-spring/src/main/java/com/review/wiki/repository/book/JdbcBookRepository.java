package com.review.wiki.repository.book;

import static com.review.wiki.util.DateTimeUtils.timestampOf;

import java.sql.PreparedStatement;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.review.wiki.model.book.Book;
import com.review.wiki.model.book.Book.Item;

@Repository
public class JdbcBookRepository implements BookRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public Optional<Item> findBytitl(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item save(Item item) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
            		"INSERT INTO "
            		+ 	"books(seq,title,link,image,author,price,discount,publisher,pubdate,isbn,description,create_at) "
            		+ "VALUES "
            		+ "	(null,?,?,?,?,?,?,?,?,?,?,?)", 
            		new String[]{"seq"});
            ps.setString(1, item.getTitle());
            ps.setString(2, item.getLink());
            ps.setString(3, item.getImage());
            ps.setString(4, item.getAuthor());
            ps.setString(5, item.getPrice());
            ps.setString(6, item.getDiscount());
            ps.setString(7, item.getPublisher());
            ps.setString(8, item.getPubdate());
            ps.setString(9, item.getIsbn());
            ps.setString(10, item.getDescription());
            ps.setTimestamp(11, timestampOf(item.getCreateAt()));
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        long generatedSeq = key != null ? key.longValue() : -1;
        return new Item.Builder(item)
                .seq(generatedSeq)
                .build();
    }	


}
