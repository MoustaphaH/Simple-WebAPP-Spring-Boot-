package WebApp.SpringFramework.bootstrap;

import WebApp.SpringFramework.Domain.Author;
import WebApp.SpringFramework.Domain.Book;
import WebApp.SpringFramework.Domain.Publisher;
import WebApp.SpringFramework.Repositories.AuthorRepository;
import WebApp.SpringFramework.Repositories.BookRepository;
import WebApp.SpringFramework.Repositories.PublisherRepository;
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
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Book DDD = new Book("Domain Driven Design", "12345");
        eric.getBooks().add(DDD);
        DDD.getAuthors().add(eric);

        DDD.setPublisher(publisher);
        publisher.getBooks().add(DDD);

        authorRepository.save(eric);
        bookRepository.save(DDD);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev without EJB", "123316554");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());

    }
}
