/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitebuilder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Maciej
 */
@ManagedBean(name = "websiteController")
@SessionScoped
public class WebsiteController {

    int user_id;
    String path;
    DataModel websiteTitles;
    WebsiteHelper helper;
    private Website current;
    private int selectedItemIndex;

    public WebsiteController() {
        helper = new WebsiteHelper();
        user_id = 0;
        path = "";
    }

    public WebsiteController(int user_id) {
        this.user_id = user_id;
    }

    public Website getSelected() {
        if (current == null) {
            current = new Website();
            selectedItemIndex = -1;
        }
        return current;
    }

    public DataModel getWebsiteTitles() {
        if (websiteTitles == null) {
            websiteTitles = new ListDataModel(helper.getWebsiteTitles(user_id));
        }
        return websiteTitles;
    }

    void recreateModel() {
        websiteTitles = null;
    }
//
//    public boolean isHasNextPage() {
//        if (endId + pageSize <= recordCount) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isHasPreviousPage() {
//        if (startId - pageSize > 0) {
//            return true;
//        }
//        return false;
//    }
//
//    public String next() {
//        startId = endId + 1;
//        endId = endId + pageSize;
//        recreateModel();
//        return "index";
//    }
//
//    public String previous() {
//        startId = startId - pageSize;
//        endId = endId - pageSize;
//        recreateModel();
//        return "index";
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
    public String prepareView() {
        current = (Website) getWebsiteTitles().getRowData();
        return "browse";
    }

    public String prepareList() {
        recreateModel();
        return "index";
    }
}
