import com.google.gson.Gson;
import database.DatabaseService;
import database.GithubUsersDao;
import entity.remote.GithubUserResponse;
import entity.user.GithubUser;
import files.FilesService;
import interactor.GithubUserInteractor;
import mapper.GithubUserMapper;
import mapper.Mapper;
import security.PropertiesService;
import util.App;

import java.util.Properties;

public class Injection {

    private static Properties PROPERTIES = new Properties();

    private static Gson GSON = new Gson();
    private static Mapper<GithubUserResponse, GithubUser> GITHUB_USER_MAPPER = new GithubUserMapper();

    private Injection() {
    }

    public static ClassLoader getClassLoader() {
        return App.getInstance().getClassLoader();
    }

    public static FilesService getFilesService() {
        return FilesService.getInstance(getClassLoader(), GSON);
    }

    public static PropertiesService getPropertiesService() {
        return PropertiesService.getInstance(getClassLoader(), PROPERTIES);
    }

    public static DatabaseService getDatabaseService() {
        return DatabaseService.getInstance(getPropertiesService());
    }

    public static GithubUserInteractor getGithubUserInteractor() {
        return GithubUserInteractor.getInstance(getFilesService(), GITHUB_USER_MAPPER);
    }

    public static GithubUsersDao getGithubUsersDao() {
        return GithubUsersDao.getInstance(getDatabaseService());
    }
}
