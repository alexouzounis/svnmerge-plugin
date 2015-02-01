import lib.JenkinsTagLib

//  Show the upstream project
def t = namespace(JenkinsTagLib.class)

h2("Subversion Integration Tracking")
p(style:"margin-left:1em") {
    text(_("This project is a feature branch of "))
    t.jobLink(job:my.branchProperty.upstreamProject)
    if(my.lastIntegratedBuild!=null){
 	   	text(_("Last Integration:  "))
    	t.buildLink(jobName:my.branchProperty.upstream, job:my.branchProperty.upstreamProject, number:my.lastIntegratedBuild.number)
	}
}
