package be.appfoundry.kotlindaggermvpretrofit.core.service

import retrofit2.http.GET
import rx.Observable

interface GithubAPI {

  @GET("/users/google/repos")
  fun getData(): Observable<List<GitHubRepo>>
}

data class GitHubRepo(val name: String, val html_url: String, val description : String)
