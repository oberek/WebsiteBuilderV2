/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitebuilder;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Maciej
 */
public class WebsiteHelper {
    Session session = null;
 
    public WebsiteHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

	public List getWebsites(int userId){
        List<Website> websites = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Website as ws where ws.user_id='"+userId+"'");
            websites = (List<Website>) q.list();
        }catch(Exception e){
            System.out.println("EXCEPTION THROWN: " + e);
        }
        return websites;
    }
    
    public Website getWebsiteByPath(String path){
        Website website = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Website as ws where ws.url='"+path+"'");
            website = (Website) q.list().get(0);
        }catch(Exception e){
            System.out.println("EXCEPTION THROWN: " + e);
        }
        return website;
    }
 
}
