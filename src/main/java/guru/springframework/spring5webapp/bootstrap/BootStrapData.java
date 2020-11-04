package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BootStrap 'run' started...");
		
		Publisher padd = new Publisher();
		padd.setName("Rajani");
		padd.setAddress1("Kadugodi");
		padd.setCity("Bangalore");
		padd.setState("Karnataka");
		padd.setZip("530067");
		publisherRepository.save(padd);
		
		Author rk = new Author("Rajani", "Kanth");
		Book d1 = new Book("Dairy", "One");
		//adding autor<->book
		rk.getBooks().add(d1);
		d1.getAuthors().add(rk);
		//adding publisher<->book
		d1.setPublisher(padd);
		padd.getBooks().add(d1);
				
		//Many to Many: making between data
		authorRepository.save(rk);
		bookRepository.save(d1);
		publisherRepository.save(padd);
		
		Author nv = new Author("Namburi", "Venkata");
		Book d2 = new Book("Dairy", "Two");
		//adding autor<->book
		nv.getBooks().add(d2);
		d2.getAuthors().add(nv);
		//adding publisher<->book
		d2.setPublisher(padd);
		padd.getBooks().add(d2);		
		
		//Many to Many: relation making between new data
		authorRepository.save(nv);
		bookRepository.save(d2);		
		publisherRepository.save(padd);
		
		System.out.println("No. of books: " + bookRepository.count());
		System.out.println("No. of Authors: " + authorRepository.count());
		System.out.println("No. of publishers: " + publisherRepository.count());
		System.out.println("Publisher has " + padd.getBooks().size() + " book(s)");
		//System.out.println("BootStrap 'run' stopped...");
	}
}
