package dao;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entity.*;
public class PersonManage {
	private SessionFactory sessionFactory;

	//����Ա��¼��֤
	@SuppressWarnings("unchecked")
	public boolean checkManager(String managerName,String managerPassword){
		Session session = sessionFactory.openSession();
		boolean flag = false;
		String hql = "from Manager as manager where manager.managerName = '"+managerName+"' and manager.managerPassword = '"+managerPassword+"'";
		List<Manager> managerList = session.createQuery(hql).list();
		if(managerList.size()>0){
			flag = true;
		}
		session.close();
		return flag;
	}
	
	//��ȡ�û���Ϣ
	public User findUser(int userId){
		User user = null;
		Session session = sessionFactory.openSession();
		try{
			user = (User)session.get("entity.User", userId);
			session.close();
			return user;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	//��ͨ�û���¼��֤
	@SuppressWarnings("unchecked")
	public User checkUser(String userName,String userPassword){
		Session session = sessionFactory.openSession();
		String hql = "from User as user where user.userName = '"+userName+"' and user.userPassword = '"+userPassword+"'";
		User user = null;
		try{
			List<User> userList = session.createQuery(hql).list();
			if(userList.size() > 0){
				user = new User();
				user = userList.get(0);
			}
		}catch(RuntimeException re){
			re.printStackTrace();
		}
		session.close();
		return user;
	}
	//���ע���û����Ƿ��Ѿ�����
	@SuppressWarnings("unchecked")
	public boolean isUserNameExist(String userName){
		Session session = sessionFactory.openSession();
		boolean flag = true;
		String hql = "from User as user where user.userName = '"+userName+"'";
		try{
			List<User> userList= session.createQuery(hql).list();
			if(userList.size() == 0){
				flag = false;
			}
			session.close();
			return flag;
		}catch (RuntimeException re) {
			throw re;
		}
	}
	//���һ���û���Ϣ
	public int addUser(User user){
		Session session = sessionFactory.openSession();
		Transaction tx= null;
		int i = 0;
		try{
			tx=session.beginTransaction();
			session.save(user);
			i = 1;
			tx.commit();
		}catch(RuntimeException re){
			tx.rollback();
			throw re;
		}
		session.close();
		return i ;
	}
	//�޸�һ���û���Ϣ
	public int updateUserInfor(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int i = 0;
		try{
			tx = session.beginTransaction();
			session.update(user);
			i = 1;
			tx.commit();
		}catch (RuntimeException re) {
			tx.rollback();
			throw re;
		}
		session.close();
		return i;
	}
	//����sexId��ѯSex
	public Sex findSex(int sexId){
		Session session = sessionFactory.openSession();
		Sex sex =null;
		try{
			sex= (Sex)session.get("entity.Sex", sexId);
			session.close();
			return sex;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
