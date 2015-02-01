package jenkins.plugins.svnmerge.RebaseAction

def t = namespace(lib.JenkinsTagLib.class)

// Rebase is complete. Display the record.
if (my.rebaseRevision!=null && my.rebaseRevision>0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Rebase source   : ${my.rebaseSource}"))
		tex(_("Rebase revision : ${my.rebaseRevision}"))	
	}		
}

if (my.rebaseRevision!=null && my.rebaseRevision==-1){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Failed to rebase due to a merge conflict"))
	}
}
        
if (my.rebaseRevision!=null && my.rebaseRevision==0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Nothing to rebase"))
	}
}
        