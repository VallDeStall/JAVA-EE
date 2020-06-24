package vlad.fedash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vlad.fedash.DBConnect.DBConnect;

public class Library {

	public static ArrayList<Reader> select() {
		ArrayList<Reader> reader = new ArrayList<Reader>();
		DBConnect.driverConnection();
		try (Connection conn = DBConnect.getConnection()) {

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ReaderList");

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String authorOfBook = resultSet.getString(2);
				String titleOfBook = resultSet.getString(3);
				int yearOfEdition = resultSet.getInt(4);
				String fullName = resultSet.getString(5);
				int cardNumber = resultSet.getInt(6);
				String phoneNumber = resultSet.getString(7);

				Reader readers = new Reader(id, authorOfBook, titleOfBook, yearOfEdition, fullName, cardNumber,
						phoneNumber);
				reader.add(readers);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return reader;

	}

	public static Reader selectOne(int id) {
		Reader reader = null;
		DBConnect.driverConnection();
		String showDatasForId = "SELECT * FROM ReaderList WHERE id=?";

		try (PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(showDatasForId)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				int index = resultSet.getInt(1);
				String authorOfBook = resultSet.getString(2);
				String titleOfBook = resultSet.getString(3);
				int yearOfEdition = resultSet.getInt(4);
				String fullName = resultSet.getString(5);
				int cardNumber = resultSet.getInt(6);
				String phoneNumber = resultSet.getString(7);

				reader = new Reader(index, authorOfBook, titleOfBook, yearOfEdition, fullName, cardNumber, phoneNumber);
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reader;

	}

	public static ArrayList<Reader> search(String card) {

		ArrayList<Reader> readers = new ArrayList<Reader>();
		DBConnect.driverConnection();
		try (Connection conn = DBConnect.getConnection()) {
			String sql = "SELECT * FROM ReaderList WHERE cardnumber = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setString(1, card);

				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int index = resultSet.getInt(1);
					String authorOfBook = resultSet.getString(2);
					String titleOfBook = resultSet.getString(3);
					int yearOfEdition = resultSet.getInt(4);
					String fullName = resultSet.getString(5);
					int cardNumber = resultSet.getInt(6);
					String phoneNumber = resultSet.getString(7);

					Reader reader = new Reader(index, authorOfBook, titleOfBook, yearOfEdition, fullName, cardNumber,
							phoneNumber);
					readers.add(reader);

				}

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return readers;
	}

	public static int insert(Reader reader) throws SQLException, IOException {
		DBConnect.driverConnection();
		try (Connection con = DBConnect.getConnection()) {

			String SQLTextIns = "INSERT INTO ReaderList (authorOfBook, titleOfBook, yearOfEdition, fullName, cardNumber, phoneNumber) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = con.prepareStatement(SQLTextIns)) {

				preparedStatement.setString(1, reader.getAuthorOfBook());
				preparedStatement.setString(2, reader.getTitleOfBook());
				preparedStatement.setInt(3, reader.getYearOfEdition());
				preparedStatement.setString(4, reader.getFullName());
				preparedStatement.setInt(5, reader.getCardNumber());
				preparedStatement.setString(6, reader.getPhoneNumber());

				return preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Ошибка добавления. Возможно есть объект с такими данными");
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static int update(Reader reader) {
		DBConnect.driverConnection();
		try (Connection conn = DBConnect.getConnection()) {

			String SQLTextUp = "UPDATE ReaderList"
					+ " SET  authorOfBook=?,titleOfBook=?,yearOfEdition=?, fullName=?,cardNumber=?,phoneNumber=?"
					+ " WHERE ID=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(SQLTextUp)) {

				preparedStatement.setString(1, reader.getAuthorOfBook());
				preparedStatement.setString(2, reader.getTitleOfBook());
				preparedStatement.setInt(3, reader.getYearOfEdition());
				preparedStatement.setString(4, reader.getFullName());
				preparedStatement.setInt(5, reader.getCardNumber());
				preparedStatement.setString(6, reader.getPhoneNumber());
				preparedStatement.setInt(7, reader.getId());

				return preparedStatement.executeUpdate();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

	public static int delete(int id) {
		DBConnect.driverConnection();
		try (Connection conn = DBConnect.getConnection()) {

			String sql = "DELETE FROM ReaderList WHERE id = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, id);

				return preparedStatement.executeUpdate();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

}
