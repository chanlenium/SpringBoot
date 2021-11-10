# SpringBoot

# MVC pattern
* Model : Send data shown in a final web page to `View`
* View : Create a final view web page
* Controller : Receive a request from a client (Link method using annotation `@GetMapping`)  

# View template & layout
* layout : define *header* and *footer* seperately (`layouts/header.mustache`, `layouts/footer.mustache`)
* Fetche layouts using `{{>layouts/header}}` and `{{>layouts/footer}}` (refer `viewTemp.mustache`)
* Link view(`viewTemp.mustache`) to web page(`/viewtemp`) using annotation `@GetMapping("/viewtemp")`

# Form data transmission
* Make form using [Bootstrap](https://getbootstrap.com/) (`articles/new.mustache`)
* Receive data sent by `post` method from From (`controller/ArticleController`)
* Define `DTO`(Data Transfer Object) as java class (`dto/ArticleForm`)
* The value of `name` attribute in Form should be same as the name of variable in DTO class

<img src="https://github.com/chanlenium/SpringBoot/blob/main/Sending%20form%20data.JPG" width="600" height="200" />

```
<input type="text" class="form-control" name="title">
```
```
public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
```

# Create data with `JPA` and `H2` database
* DB does not know JAVA language, so we use `JPA` for DB to understand JAVA language
* Key tools of JPA are *Entity* and *Repository*
* *Entity* is a standardized data that DB can understand it
* *Repository* sends the standardized entity to database

<img src="https://github.com/chanlenium/SpringBoot/blob/main/Create%20data%20with%20JPA.JPG" width="600" height="200" />

1. Make entity class (`entity/Article.java`)
```css
@Entity // Add `@Entity` annotation, so that DB can understand the Article object
public class Article {

    @Id // Set this variable as primary key
    @GeneratedValue // auto generation
    private Long id;

    @Column // make column
    private String title;

    @Column // make column
    private String content;

    // constructor
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
```

2. Create an entity (define `toEntity()` in `ArticleForm`)
```
Article artile = form.toEntity();
```

3. Make Repository interface (/repository/ArticleRepository)
```
/** Use repository interface provided in JPA library
 * CrudRepository<A, B>
 *     A : name of entity class
 *     B : type of primary key
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    // Inherit a `CrudRepository` to use CRUD operation for Article entity 
}
```

4. Repository saves the entity in DB
```
Article saved = articleRepository.save(artile);
```

# DB table and SQL
  
