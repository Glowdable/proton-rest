package cn.glowd.proton.core.model;

/***
 * SampleModel,业务相关的核心模型
 * 
 * @author glowd
 * @date 2018/02/23
 */
public class SampleModel {

    private Long id;
    private Integer packageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("id=").append(id);
        sb.append(", packageId=").append(packageId);
        sb.append("]");
        return sb.toString();
    }

}