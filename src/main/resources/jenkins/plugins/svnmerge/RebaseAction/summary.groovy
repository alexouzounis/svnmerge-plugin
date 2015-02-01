package jenkins.plugins.svnmerge.RebaseAction

def t = namespace(lib.JenkinsTagLib.class)

// Rebase is complete. Display the record.
h2 (style:"margin-top:2em", _("Result of Rebase:"))

if (my.integratedRevision>0){
	tex(_("UpSteam revision rebased from: ${my.revisionToIntegrateFrom}"))
	tex(_("Integrated revision          : ${my.integratedRevision}"))			
}else{
	tex(_("Rebase failed due to a merge conflict."))
}
        