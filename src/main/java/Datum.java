import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("isbn13")
    @Expose
    private String isbn13;
    @SerializedName("publisher_id")
    @Expose
    private String publisherId;
    @SerializedName("dewey_decimal")
    @Expose
    private String deweyDecimal;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("publisher_text")
    @Expose
    private String publisherText;
    @SerializedName("edition_info")
    @Expose
    private String editionInfo;
    @SerializedName("book_id")
    @Expose
    private String bookId;
    @SerializedName("author_data")
    @Expose
    private List<AuthorDatum> authorData = null;
    @SerializedName("awards_text")
    @Expose
    private String awardsText;
    @SerializedName("subject_ids")
    @Expose
    private List<String> subjectIds = null;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("title_latin")
    @Expose
    private String titleLatin;
    @SerializedName("title_long")
    @Expose
    private String titleLong;
    @SerializedName("publisher_name")
    @Expose
    private String publisherName;
    @SerializedName("dewey_normal")
    @Expose
    private String deweyNormal;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("physical_description_text")
    @Expose
    private String physicalDescriptionText;
    @SerializedName("isbn10")
    @Expose
    private String isbn10;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("urls_text")
    @Expose
    private String urlsText;
    @SerializedName("marc_enc_level")
    @Expose
    private String marcEncLevel;
    @SerializedName("lcc_number")
    @Expose
    private String lccNumber;

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getDeweyDecimal() {
        return deweyDecimal;
    }

    public void setDeweyDecimal(String deweyDecimal) {
        this.deweyDecimal = deweyDecimal;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisherText() {
        return publisherText;
    }

    public void setPublisherText(String publisherText) {
        this.publisherText = publisherText;
    }

    public String getEditionInfo() {
        return editionInfo;
    }

    public void setEditionInfo(String editionInfo) {
        this.editionInfo = editionInfo;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public List<AuthorDatum> getAuthorData() {
        return authorData;
    }

    public void setAuthorData(List<AuthorDatum> authorData) {
        this.authorData = authorData;
    }

    public String getAwardsText() {
        return awardsText;
    }

    public void setAwardsText(String awardsText) {
        this.awardsText = awardsText;
    }

    public List<String> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<String> subjectIds) {
        this.subjectIds = subjectIds;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitleLatin() {
        return titleLatin;
    }

    public void setTitleLatin(String titleLatin) {
        this.titleLatin = titleLatin;
    }

    public String getTitleLong() {
        return titleLong;
    }

    public void setTitleLong(String titleLong) {
        this.titleLong = titleLong;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getDeweyNormal() {
        return deweyNormal;
    }

    public void setDeweyNormal(String deweyNormal) {
        this.deweyNormal = deweyNormal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhysicalDescriptionText() {
        return physicalDescriptionText;
    }

    public void setPhysicalDescriptionText(String physicalDescriptionText) {
        this.physicalDescriptionText = physicalDescriptionText;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUrlsText() {
        return urlsText;
    }

    public void setUrlsText(String urlsText) {
        this.urlsText = urlsText;
    }

    public String getMarcEncLevel() {
        return marcEncLevel;
    }

    public void setMarcEncLevel(String marcEncLevel) {
        this.marcEncLevel = marcEncLevel;
    }

    public String getLccNumber() {
        return lccNumber;
    }

    public void setLccNumber(String lccNumber) {
        this.lccNumber = lccNumber;
    }

}