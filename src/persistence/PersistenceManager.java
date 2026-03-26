package persistence;

import manager.UserManager;
import manager.VaultManager;
import model.User;
import model.Vault;

import java.io.*;
import java.util.List;

public class PersistenceManager {

    private static final String USERS_FILE = "users.dat";
    private static final String VAULTS_FILE = "vaults.dat";

    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(UserManager.getInstance().getAllUsers());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VAULTS_FILE))) {
            oos.writeObject(VaultManager.getInstance().getAllVaults());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            List<User> users = (List<User>) ois.readObject();
            UserManager.getInstance().setUsers(users);
        } catch (Exception e) {
            System.err.println("No users file found, starting fresh.");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(VAULTS_FILE))) {
            List<Vault> vaults = (List<Vault>) ois.readObject();
            VaultManager.getInstance().setVaults(vaults);
        } catch (Exception e) {
            System.err.println("No vaults file found, starting fresh.");
        }
    }
}
