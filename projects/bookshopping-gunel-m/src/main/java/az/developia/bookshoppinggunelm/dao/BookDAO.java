package az.developia.bookshoppinggunelm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshoppinggunelm.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
