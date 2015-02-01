package jenkins.plugins.svnmerge.RebaseAction

def t = namespace(lib.JenkinsTagLib.class)

// Rebase is complete. Display the record.

t.summary(icon:"/plugin/svnmerge/48x48/integrate.gif") {
    text(_("This build is integrated into "))
    t.buildLink(jobName:my.property.upstream, job:my.property.upstreamProject, number:n)
}

h2 (style:"margin-top:2em", _("Result of Rebase:"))

if (my.integratedRevision>0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("UpSteam revision rebased from: ${my.revisionToIntegrateFrom}"))
		tex(_("Integrated revision          : ${my.integratedRevision}"))	
	}		
}

if (my.integratedRevision==-1){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Failed to rebase due to a merge conflict"))
	}
}
        
if (my.integratedRevision==0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Nothing to rebase"))
	}
}
        