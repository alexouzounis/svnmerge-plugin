import lib.JenkinsTagLib

//  Show the upstream project
def t = namespace(JenkinsTagLib.class)

h2("Subversion Rebase Tracking")
p(style:"margin-left:1em") {
    text(_("This project is a feature branch of "))
    t.jobLink(job:my.branchProperty.upstreamProject)
    if(my.lastrebasedbuild!=null){
 	   	text(_("Last Rebase:  "))
    	t.buildLink(jobName:my.branchProperty.upstream, job:my.branchProperty.upstreamProject, number:my.lastrebasedbuild.number)
	}
}
