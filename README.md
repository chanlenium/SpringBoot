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
* `H2` database setting (/resources/application.properties)
```
# h2 DB를 web console로 접근할 수 있도록 설정
spring.h2.console.enabled = true 
```
* Access data base (`localhost:8080/h2-console`) and set JDBC URL in console window of the intellij

#Lombok and Refactoring
* 필수 코드의 반복을 최소화 :-> 코드 간소화
* REfactoring : 코드의 구조 및 성능을 개선하는 작업
* Logging : 프로그램의 수행과정을 기록으로 남기는 것(자동차 블랙박스)
* bulid.gradle에서 롬복 추가 (dependendies에 library 추가)
* // 1. 롬복 추가
* compileOnly...
* annotationProsessor.. 추가 후 새로고침(코끼리 버튼 클릭)
* // 2. 롬복 플러그인 설치
* help > finde action > market place -> lombok 인스톨 > enable 클릭(annotaion process)
* // 3. DTo 리팩토링
* articleform에 @AllArgsConstructor, @ToString 추가 > 생성자 tostring override삭제(주석처리)
* // 4. Entity 리팩토링
* Article에 생성자, toSTring 주석처리하고 @AllArgsConstructor, @ToString 추가
* // 5. 로그남기기
* controller > ArticleCOntroller에서 system.out.prinltn를 주석처리하고 로깅 기능으로 대체
* @Slf4j추가 // ㄹ깅을 위한 어노테이션
* system.out.prinltn을 log.info(form.toString()) 등으로 코드 개선
* 
* 
*  

  
