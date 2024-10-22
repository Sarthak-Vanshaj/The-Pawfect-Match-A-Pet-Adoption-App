package backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetController {
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT id, name, breed, age, description, adopted_by FROM pets";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setBreed(rs.getString("breed"));
                pet.setAge(rs.getInt("age"));
                pet.setDescription(rs.getString("description"));
                pet.setAdoptedBy(rs.getInt("adopted_by"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public void adoptPet(int petId, int userId) {
        try (Connection conn = Database.getConnection()) {
            String query = "UPDATE pets SET adopted_by=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setInt(2, petId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
