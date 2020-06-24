package vlad.fedash.DB;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import vlad.fedash.entity.BookDatas;
import vlad.fedash.entity.Reader;

public class DBActions {

	public static ArrayList<Reader> reviewReader(SessionFactory sf) {
		ArrayList<Reader> reader = new ArrayList<Reader>();
		Session session = null;
		List<?> results = null;
		Transaction tx = null;
		Query q;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			q = session.createQuery("FROM Reader");
			results = q.getResultList();
			for (int i = 0; i < results.size(); i++) {
				reader.add((Reader) results.get(i));
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return reader;
	}

	public static ArrayList<Reader> searchReader(SessionFactory sf, String cardNumber) {
		ArrayList<Reader> reader = new ArrayList<Reader>();
		Session session = null;
		Transaction tx = null;
		Query q = null;
		List<?> sults = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			q = session.createQuery("FROM Reader Where cardNumber='" + cardNumber + "'");
			sults = q.getResultList();
			for (int i = 0; i < sults.size(); i++) {
				reader.add((Reader) sults.get(i));
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {

				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return reader;
	}

	public static void createReader(SessionFactory sf, Reader newObject) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			session.save(newObject);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void editReader(SessionFactory sf, Reader newObject, int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Reader newReader = (Reader) session.get(Reader.class, id);

			newReader.setFullName(newObject.getFullName());
			newReader.setCardNumber(newObject.getCardNumber());
			newReader.setPhoneNumber(newObject.getPhoneNumber());

			session.update(newReader);
			tx.commit();
//			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void deleteReader(SessionFactory sf, int id) {
		if (id == -1) {
			return;
		}
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Reader del = (Reader) session.get(Reader.class, id);
			session.delete(del);
			tx.commit();
		} catch (Exception ex) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static Reader searchIndexReader(SessionFactory sf, int ind) {
		Reader results = new Reader();

		Session session = null;
		Transaction tx = null;
		Query q = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			q = session.createQuery("FROM Reader Where id =" + ind);
			results = (Reader) q.getResultList().get(0);
			tx.commit();
			return results;
		} catch (Exception e) {
			if (tx != null) {

				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return results;
	}

	public static ArrayList<BookDatas> reviewBookDatas(SessionFactory sf) {
		ArrayList<BookDatas> res = new ArrayList<BookDatas>();
		List<?> results = null;
		Session session = null;
		Transaction tx = null;
		Query q = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			q = session.createQuery("FROM BookDatas");
			results = q.getResultList();
			for (int i = 0; i < results.size(); i++) {
				res.add((BookDatas) results.get(i));
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return res;
	}

	public static void createBookDatas(SessionFactory sf, BookDatas newObject) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			session.save(newObject);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void editBookDatas(SessionFactory sf, BookDatas newObject, int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			BookDatas editBookDatas = (BookDatas) session.get(BookDatas.class, id);

			editBookDatas.setAuthorOfBook(newObject.getAuthorOfBook());
			editBookDatas.setTitleOfBook(newObject.getTitleOfBook());
			editBookDatas.setYearOfEdition(newObject.getYearOfEdition());
			editBookDatas.setReader(newObject.getReader());

			session.update(editBookDatas);
			tx.commit();
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void deleteBookDatas(SessionFactory sf, int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			BookDatas del = (BookDatas) session.get(BookDatas.class, id);
			session.delete(del);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static BookDatas searchIndexBookDatas(SessionFactory sf, int ind) {
		BookDatas results = new BookDatas();

		Session session = null;
		Transaction tx = null;
		Query q = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			q = session.createQuery("FROM BookDatas Where ide =" + ind);
			results = (BookDatas) q.getResultList().get(0);
			tx.commit();
			return results;
		} catch (Exception e) {
			if (tx != null) {

				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return results;
	}

	public static ArrayList<BookDatas> searchBookDatas(SessionFactory sf, String year) {
		ArrayList<BookDatas> res = new ArrayList<BookDatas>();
		List<?> results = null;
		Session session = null;
		Transaction tx = null;
		Query q = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			q = session.createQuery("FROM BookDatas Where yearOfEdition ='" + year + "'");
			results = q.getResultList();
			for (int i = 0; i < results.size(); i++) {
				res.add((BookDatas) results.get(i));
			}
			tx.commit();
			return res;
		} catch (Exception e) {
			if (tx != null) {

				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return res;
	}

	public static boolean userIsExist(SessionFactory sf, String login, String password) {
		Session session = null;
		Transaction tx = null;
		Query q = null;
		boolean res = false;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			q = session.createQuery("FROM Users Where username ='" + login + "' and password = '" + password + "'");
			System.out.println(q);
			if (q.getResultList().size() > 0)
				res = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return res;

	}
}
