import lib.JenkinsTagLib

//  Show the upstream project
def t = namespace(JenkinsTagLib.class)

if(my.lastRebasedBuild!=null){
	p(style:"margin-left:1em") {
		text(_("Last Rebase:  "))
		t.buildLink(jobName:my.branchProperty.owner.name, job:my.branchProperty.owner, number:my.lastRebasedBuild.number)
		
	}
}