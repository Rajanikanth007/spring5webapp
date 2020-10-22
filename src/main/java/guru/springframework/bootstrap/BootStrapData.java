package guru.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Author;
import guru.springframework.domain.Book;
import guru.springframework.domain.Publisher;
import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.BookRepository;
import guru.springframework.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BootStrap 'run' started...");
		
		Publisher padd = new Publisher();
		padd.setName("Murali");
		padd.setAddress1("Kadugodi");
		padd.setCity("Bangalore");
		padd.setState("Karnataka");
		padd.setZip("530067");
		publisherRepository.save(padd);
		
		System.out.println("No. of publishers: " + publisherRepository.count());
		
		Author mv = new Author("Murali", "Veligeti");
		Book d1 = new Book("Dairy", "One");
		
		mv.getBooks().add(d1);
		d1.getAuthors().add(mv);
		
		authorRepository.save(mv);
		bookRepository.save(d1);
				
		System.out.println("No. of books: " + bookRepository.count());
		System.out.println("No. of Authors: " + authorRepository.count());
		
		System.out.println("BootStrap 'run' stopped...");
	}

	
}
