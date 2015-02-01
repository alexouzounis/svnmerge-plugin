package jenkins.plugins.svnmerge.IntegrateAction

def f = namespace(lib.FormTagLib.class)
def l = namespace(lib.LayoutTagLib.class)
def t = namespace(lib.JenkinsTagLib.class)
def st = namespace("jelly:stapler")

l.layout(norefresh:"true", title:"#${my.build.number} Integration") {
    include(my.build, "sidepanel")
    l.main_panel {
        img(src:"${rootURL}/plugin/svnmerge/48x48/integrate.gif")
        text(_("title", my.build.displayName))

        p {
            text("This will merge ${my.svnInfo} to")
            t.jobLink(job:my.property.upstreamProject)
        }

        form(action:"perform", method:"post", name:"integrate") {
			f.entry(title:_("Commit Message Comment (Optional)")) {
			    f.textbox(name: "comment", value: "", class: "fixed-width")
			}
			f.entry(title:_("Issue Number(s) (Optional)")) {
			    f.textbox(name: "issues", value: "", class: "fixed-width")
			}
            
            f.submit(value:_("Integrate this build to upstream"))
        }


        h2 (style:"margin-top:2em", _("Result of Last Integration"))

		if (my.integratedrevision>0){
			tex(_("Integration source   : ${my.integrationsource}"))
			tex(_("Integrated revision  : ${my.integratedrevision}"))			
		}

    }
}
