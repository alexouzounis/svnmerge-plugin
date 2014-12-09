package jenkins.plugins.svnmerge.RebaseAction

def f = namespace(lib.FormTagLib.class)
def l = namespace(lib.LayoutTagLib.class)
def t = namespace(lib.JenkinsTagLib.class)
def st = namespace("jelly:stapler")

l.layout(norefresh:true, title:_("Rebase changes from upstream")) {
    include(my.project, "sidepanel")
    l.main_panel {
        h1 {
            img(src:"${rootURL}/plugin/svnmerge/48x48/sync.gif")
            text(_("Rebase changes from upstream"))
        }

        def up = my.property.upstreamProject

        p {
            text("This will integrate the changes made in ")
            t.jobLink(job:up)
            text(" into this project.")
        }

        form (action:"perform",method:"post",name:"rebase") {
            p {
                tex(_("Revision/build to rebase to: "))
                select (name:"permalink") {
                    option(value:"(default)", _("Latest revision"))
                    up.permalinks.each { p ->
                        def b = p.resolve(up)
                        if (b!=null)
                            option(value:p.id, "${p.displayName} (${b.displayName})")
                    }
                }
            }
			f.entry(title:_("Commit Message Comment (Optional)")) {
			    f.textarea(name: "comment", value: "", class: "fixed-width")
			}
			f.entry(title:_("Issue Number(s) (Optional)")) {
			    f.textarea(name: "issues", value: "", class: "fixed-width")
			}
            f.submit(value:_("Rebase"))
        }

        if (my.logFile.exists()) {
            h2 (style:"margin-top:2em", _("Result of Last Rebase"))
            pre {
                st.copyStream(reader:my.log.readAll())
            }
        }
    }
}