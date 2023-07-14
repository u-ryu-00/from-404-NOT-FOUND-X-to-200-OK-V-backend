package kr.megaptera.F4T2.dtos;

public class UpdateReviewDto {
    private Long id;

    private String title;

    private Integer rating;

    private String content;

    public UpdateReviewDto() {
    }

    public UpdateReviewDto(Long id, String title, Integer rating, String content) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }
}
