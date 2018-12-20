package interactor;

import com.google.gson.reflect.TypeToken;
import entity.remote.GithubUserResponse;
import entity.user.GithubUser;
import files.FilesService;
import mapper.Mapper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class GithubUserInteractor {

    private static final String GITHUB_USER_STATS_JSON = "github-users-stats.json";
    private static final Type GITHUB_USER_TYPE = new TypeToken<List<GithubUserResponse>>() {
    }.getType();

    private final FilesService filesService;
    private Mapper<GithubUserResponse, GithubUser> githubUserMapper;

    public GithubUserInteractor(FilesService filesService, Mapper<GithubUserResponse, GithubUser> githubUserMapper) {
        this.filesService = filesService;
        this.githubUserMapper = githubUserMapper;
    }

    public List<GithubUser> getGithubUsers() {
        List<GithubUserResponse> list = filesService.read(GITHUB_USER_STATS_JSON, GITHUB_USER_TYPE);
        return list.stream()
                .map((githubUserResponse -> githubUserMapper.map(githubUserResponse)))
                .collect(Collectors.toList());
    }

    private static GithubUserInteractor githubUserInteractor;

    public static GithubUserInteractor getInstance(FilesService filesService, Mapper<GithubUserResponse,
            GithubUser> githubUserMapper) {
        if (githubUserInteractor == null) {
            githubUserInteractor = new GithubUserInteractor(filesService, githubUserMapper);
        }
        return githubUserInteractor;
    }
}
