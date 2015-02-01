package jenkins.plugins.svnmerge.RebaseAction

def t = namespace(lib.JenkinsTagLib.class)

// Rebase is complete. Display the record.
if (my.rebaserevision!=null && my.rebaserevision>0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Rebase source   : ${my.rebasesource}"))
		tex(_("Rebase revision : ${my.rebaserevision}"))	
	}		
}

if (my.rebaserevision!=null && my.rebaserevision==-1){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Failed to rebase due to a merge conflict"))
	}
}
        
if (my.rebaserevision!=null && my.rebaserevision==0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		tex(_("Nothing to rebase"))
	}
}
        