package cn.glowd.proton.rest.api.vo.reponse;

import java.io.Serializable;

/***
 * 即使HealthPackageVO与HealthPackageDO字段完全一致，也必须解耦
 * 
 * @author glowd
 * @date 2018/02/23
 */
public class HealthPackageResponseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer packageId;
    private Integer moduleId;

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

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", packageId=").append(packageId);
        sb.append(", moduleId=").append(moduleId);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HealthPackageResponseVO other = (HealthPackageResponseVO)that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPackageId() == null ? other.getPackageId() == null
                : this.getPackageId().equals(other.getPackageId()))
            && (this.getModuleId() == null ? other.getModuleId() == null
                : this.getModuleId().equals(other.getModuleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPackageId() == null) ? 0 : getPackageId().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        return result;
    }
}