package app.bean.admin;

import app.bean.ConfigAddBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 20.07.12
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class ConfigSharedBean implements Serializable {

    @ManagedProperty("#{configAddBean}")
    ConfigAddBean configAddBean;

    @ManagedProperty("#{configBean}")
    ConfigBean configBean;

    public void saveParameter() {
        configAddBean.saveParameter();
        configBean.refreshConfigsList();
    }

    public void updateParameter() {
        configBean.updateParameter();
        configBean.refreshConfigsList();
    }

    public void setConfigAddBean(ConfigAddBean configAddBean) {
        this.configAddBean = configAddBean;
    }

    public void setConfigBean(ConfigBean configBean) {
        this.configBean = configBean;
    }
}
