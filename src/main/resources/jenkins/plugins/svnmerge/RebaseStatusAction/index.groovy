//   Show the last integration status
package jenkins.plugins.svnmerge.IntegrationStatusAction

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

        def ia = my.lastRebaseAction;

        if (ia==null) {
            p {
                text("This project has not been rebased yet ")
                a(href: Functions.getRelativeLinkTo(my.branchProperty.upstreamProject), "the upstream")
                text(" yet.")
            }
        } else {
            p {
                text("Last Rebase was from ")
                a(href: Functions.getRelativeLinkTo(my.property.upstreamProject), "the upstream")
                text(", revision ${rebaseSource}, integrated in revision ${rebaseRevision}")
            }
        }
    }
}