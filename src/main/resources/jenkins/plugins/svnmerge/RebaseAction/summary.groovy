package jenkins.plugins.svnmerge.RebaseAction

import hudson.Functions

def t = namespace(lib.JenkinsTagLib.class)

// Rebase is complete. Display the record.
if (my.rebaseRevision!=null && my.rebaseRevision>0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		p {
			text(_("Rebase from     :"))
			a(href: Functions.getRelativeLinkTo(my.project), my.project.name)
		}
		p {
			text(_("Rebase source   : ${my.rebaseSource}"))
		}
		p {
			text(_("Rebase revision : ${my.rebaseRevision}"))	
		}
	}		
}

if (my.rebaseRevision!=null && my.rebaseRevision==-1){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		text(_("Failed to rebase due to a merge conflict"))
	}
}
        
if (my.rebaseRevision!=null && my.rebaseRevision==0){
	t.summary(icon:"/plugin/svnmerge/48x48/sync.gif") {
		text(_("Nothing to rebase"))
	}
}
        