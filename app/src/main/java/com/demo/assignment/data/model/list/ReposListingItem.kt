package com.demo.assignment.data.model.list


import androidx.room.*
import com.demo.assignment.core.Constants
import com.demo.assignment.data.db.AppConverters
import com.google.gson.annotations.SerializedName


@Entity(tableName = Constants.DB.Table.Repo.NAME, indices = [Index(value = ["id"], unique = true)])
data class ReposListingItem(

    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    @SerializedName("name")
    val name: String?,

    @SerializedName("open_issues_count")
    val openIssuesCount: String?,

    @SerializedName("node_id")
    val nodeId: String?,

    @SerializedName("description")
    val description: String?,


    @SerializedName("license")
    @TypeConverters(AppConverters::class)
    val license: License?,

    @SerializedName("owner")
    @TypeConverters(AppConverters::class)
    val owner: Owner?,

    @SerializedName("permissions")
    @TypeConverters(AppConverters::class)
    val permissions: Permissions?,

    ) {

    //Ignored for DB tasks

    @Ignore
    @SerializedName("full_name")
    val fullName: String? = null

    @Ignore
    @SerializedName("private")
    val `private`: Boolean? = null

    @Ignore
    @SerializedName("html_url")
    val htmlUrl: String? = null

    @Ignore
    @SerializedName("fork")
    val fork: Boolean? = null

    @Ignore
    @SerializedName("url")
    val url: String? = null

    @Ignore
    @SerializedName("forks_url")
    val forksUrl: String? = null

    @Ignore
    @SerializedName("keys_url")
    val keysUrl: String? = null

    @Ignore
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String? = null

    @Ignore
    @SerializedName("teams_url")
    val teamsUrl: String? = null

    @Ignore
    @SerializedName("hooks_url")
    val hooksUrl: String? = null

    @Ignore
    @SerializedName("issue_events_url")
    val issueEventsUrl: String? = null

    @Ignore
    @SerializedName("events_url")
    val eventsUrl: String? = null

    @Ignore
    @SerializedName("assignees_url")
    val assigneesUrl: String? = null

    @Ignore
    @SerializedName("branches_url")
    val branchesUrl: String? = null

    @Ignore
    @SerializedName("tags_url")
    val tagsUrl: String? = null

    @Ignore
    @SerializedName("blobs_url")
    val blobsUrl: String? = null

    @Ignore
    @SerializedName("git_tags_url")
    val gitTagsUrl: String? = null

    @Ignore
    @SerializedName("git_refs_url")
    val gitRefsUrl: String? = null

    @Ignore
    @SerializedName("trees_url")
    val treesUrl: String? = null

    @Ignore
    @SerializedName("statuses_url")
    val statusesUrl: String? = null

    @Ignore
    @SerializedName("languages_url")
    val languagesUrl: String? = null

    @Ignore
    @SerializedName("stargazers_url")
    val stargazersUrl: String? = null

    @Ignore
    @SerializedName("contributors_url")
    val contributorsUrl: String? = null

    @Ignore
    @SerializedName("subscribers_url")
    val subscribersUrl: String? = null

    @Ignore
    @SerializedName("subscription_url")
    val subscriptionUrl: String? = null

    @Ignore
    @SerializedName("commits_url")
    val commitsUrl: String? = null

    @Ignore
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String? = null

    @Ignore
    @SerializedName("comments_url")
    val commentsUrl: String? = null

    @Ignore
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String? = null

    @Ignore
    @SerializedName("contents_url")
    val contentsUrl: String? = null

    @Ignore
    @SerializedName("compare_url")
    val compareUrl: String? = null

    @Ignore
    @SerializedName("merges_url")
    val mergesUrl: String? = null

    @Ignore
    @SerializedName("archive_url")
    val archiveUrl: String? = null

    @Ignore
    @SerializedName("downloads_url")
    val downloadsUrl: String? = null

    @Ignore
    @SerializedName("issues_url")
    val issuesUrl: String? = null

    @Ignore
    @SerializedName("pulls_url")
    val pullsUrl: String? = null

    @Ignore
    @SerializedName("milestones_url")
    val milestonesUrl: String? = null

    @Ignore
    @SerializedName("notifications_url")
    val notificationsUrl: String? = null

    @Ignore
    @SerializedName("labels_url")
    val labelsUrl: String? = null

    @Ignore
    @SerializedName("releases_url")
    val releasesUrl: String? = null

    @Ignore
    @SerializedName("deployments_url")
    val deploymentsUrl: String? = null

    @Ignore
    @SerializedName("created_at")
    val createdAt: String? = null

    @Ignore
    @SerializedName("updated_at")
    val updatedAt: String? = null

    @Ignore
    @SerializedName("pushed_at")
    val pushedAt: String? = null

    @Ignore
    @SerializedName("git_url")
    val gitUrl: String? = null

    @Ignore
    @SerializedName("ssh_url")
    val sshUrl: String? = null

    @Ignore
    @SerializedName("clone_url")
    val cloneUrl: String? = null

    @Ignore
    @SerializedName("svn_url")
    val svnUrl: String? = null

    @Ignore
    @SerializedName("homepage")
    val homepage: String? = null

    @Ignore
    @SerializedName("size")
    val size: Int? = null

    @Ignore
    @SerializedName("stargazers_count")
    val stargazersCount: Int? = null

    @Ignore
    @SerializedName("watchers_count")
    val watchersCount: Int? = null

    @Ignore
    @SerializedName("language")
    val language: String? = null

    @Ignore
    @SerializedName("has_issues")
    val hasIssues: Boolean? = null

    @Ignore
    @SerializedName("has_projects")
    val hasProjects: Boolean? = null

    @Ignore
    @SerializedName("has_downloads")
    val hasDownloads: Boolean? = null

    @Ignore
    @SerializedName("has_wiki")
    val hasWiki: Boolean? = null

    @Ignore
    @SerializedName("has_pages")
    val hasPages: Boolean? = null

    @Ignore
    @SerializedName("forks_count")
    val forksCount: Int? = null

    @Ignore
    @SerializedName("mirror_url")
    val mirrorUrl: Any? = null

    @Ignore
    @SerializedName("archived")
    val archived: Boolean? = null

    @Ignore
    @SerializedName("disabled")
    val disabled: Boolean? = null

    @Ignore
    @SerializedName("forks")
    val forks: Int? = null

    @Ignore
    @SerializedName("open_issues")
    val openIssues: Int? = null

    @Ignore
    @SerializedName("watchers")
    val watchers: Int? = null

    @Ignore
    @SerializedName("default_branch")
    val defaultBranch: String? = null
}