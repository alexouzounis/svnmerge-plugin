import lib.JenkinsTagLib

//  Show the upstream project
def t = namespace(JenkinsTagLib.class)

if(my.lastRebasedBuild!=null){
	p(style:"margin-left:1em") {
		text(_("Last Rebase:  "))
		t.buildLink(jobName:my.branchProperty.upstream, job:my.branchProperty.upstreamProject, number:my.lastRebasedBuild.number)
	}
}