import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Isbndb {

    @SerializedName("result_count")
    @Expose
    private Integer resultCount;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount;
    @SerializedName("index_searched")
    @Expose
    private String indexSearched;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getIndexSearched() {
        return indexSearched;
    }

    public void setIndexSearched(String indexSearched) {
        this.indexSearched = indexSearched;
    }

}