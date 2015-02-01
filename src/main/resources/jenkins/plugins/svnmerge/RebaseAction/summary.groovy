package jenkins.plugins.svnmerge.RebaseAction

def t = namespace(lib.JenkinsTagLib.class)

// Rebase is complete. Display the record.
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
        