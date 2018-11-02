package sebamdq.springframework.spring5webapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sebamdq.springframework.spring5webapp.model.Author;
import sebamdq.springframework.spring5webapp.model.Book;
import sebamdq.springframework.spring5webapp.model.Publisher;
import sebamdq.springframework.spring5webapp.repositories.AuthorRepository;
import sebamdq.springframework.spring5webapp.repositories.BookRepository;
import sebamdq.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisherA = new Publisher("Pepe", "EverGreen 123");
        Book ddd = new Book("Domain Driven Design", "1234");
        ddd.setPublisher(publisherA);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisherA);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisherB = new Publisher("Grillo","EverGreen 456");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        noEJB.setPublisher(publisherB);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(publisherB);
        bookRepository.save(noEJB);
    }
}

