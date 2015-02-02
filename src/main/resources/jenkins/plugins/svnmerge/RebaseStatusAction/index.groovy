//   Show the last integration status
package jenkins.plugins.svnmerge.RebaseStatusAction

import lib.LayoutTagLib
import lib.JenkinsTagLib
import hudson.Functions

def l = namespace(LayoutTagLib.class)
def t = namespace(JenkinsTagLib.class)

l.layout(norefresh:true, title:_("title",my.project.displayName)) {
    include(my.project, "sidepanel")
    l.main_panel {
        h1 {
            img(src:"${rootURL}/plugin/svnmerge/48x48/sync.gif")
            text(_("title",my.project.displayName))
        }

        def ra = my.lastRebaseAction;

        if (ra==null) {
            p {
                text("This project has not been rebased from ")
                a(href: Functions.getRelativeLinkTo(my.branchProperty.upstreamProject), "the upstream")
                text(" yet.")
            }
        } else {
            p {
            	if (ra.build!=null){
                	text("Last Rebase build: ")
                	t.buildLink(jobName:my.branchProperty.owner.name, job:my.branchProperty.owner, number:ra.build.number)
				}	
				text("Last Rebase from ")
				a(href: Functions.getRelativeLinkTo(my.branchProperty.upstreamProject), "the upstream")
				text(", revision ${ra.rebaseSource}, integrated in revision ${ra.rebaseRevision} ")
				
            }
        }
    }
}
