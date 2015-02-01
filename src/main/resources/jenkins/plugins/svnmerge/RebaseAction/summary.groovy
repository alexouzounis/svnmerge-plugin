package jenkins.plugins.svnmerge.RebaseAction

def t = namespace(lib.JenkinsTagLib.class)

// Rebase is complete. Display the record.
h2 (style:"margin-top:2em", _("Result of Rebase:"))

if (my.integratedRevision>0){
	tex(_("UpSteam revision rebased from: ${my.revisionToIntegrateFrom}"))
	tex(_("Integrated revision          : ${my.integratedRevision}"))			
}

if (my.integratedRevision==-1){
	tex(_("Rebase failed due to a merge conflict."))
}
        
 if (my.integratedRevision==0){
 	tex(_("Nothing to rebase."))
 }
        