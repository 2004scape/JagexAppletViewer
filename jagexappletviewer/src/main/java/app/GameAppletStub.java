package app;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Enumeration;
import java.util.Iterator;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/ba")
public final class GameAppletStub implements AppletStub, AppletContext {

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getImage", descriptor = "(Ljava/net/URL;)Ljava/awt/Image;")
	@Override
	public Image getImage(@OriginalArg(0) URL url) {
		throw new UnsupportedOperationException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "showStatus", descriptor = "(Ljava/lang/String;)V")
	@Override
	public void showStatus(@OriginalArg(0) String url) {
		throw new UnsupportedOperationException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getCodeBase", descriptor = "()Ljava/net/URL;")
	@Override
	public URL getCodeBase() {
		try {
			return new URL(AppletViewer.getProperty("codebase"));
		} catch (@Pc(7) MalformedURLException ignored) {
			throw new InvalidParameterException();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "showDocument", descriptor = "(Ljava/net/URL;)V")
	@Override
	public void showDocument(@OriginalArg(0) URL url) {
		if (AppletViewer.VERBOSE) {
			System.out.println("showdocument url:" + url);
		}

		UrlThread.showurl(url.toString(), null);
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getApplets", descriptor = "()Ljava/util/Enumeration;")
	@Override
	public Enumeration getApplets() {
		throw new UnsupportedOperationException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "setStream", descriptor = "(Ljava/lang/String;Ljava/io/InputStream;)V")
	@Override
	public void setStream(@OriginalArg(0) String key, @OriginalArg(1) InputStream stream) throws IOException {
		throw new UnsupportedOperationException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getAppletContext", descriptor = "()Ljava/applet/AppletContext;")
	@Override
	public AppletContext getAppletContext() {
		return this;
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "showDocument", descriptor = "(Ljava/net/URL;Ljava/lang/String;)V")
	@Override
	public void showDocument(@OriginalArg(0) URL url, @OriginalArg(1) String target) {
		if (AppletViewer.VERBOSE) {
			System.out.println("showdocument url:" + url + " target:" + target);
		}

		UrlThread.showurl(url.toString(), target);
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "appletResize", descriptor = "(II)V")
	@Override
	public void appletResize(@OriginalArg(0) int width, @OriginalArg(1) int height) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getApplet", descriptor = "(Ljava/lang/String;)Ljava/applet/Applet;")
	@Override
	public Applet getApplet(@OriginalArg(0) String name) {
		throw new UnsupportedOperationException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getParameter", descriptor = "(Ljava/lang/String;)Ljava/lang/String;")
	@Override
	public String getParameter(@OriginalArg(0) String name) {
		@Pc(3) String value = AppletViewer.getParameter(name);

		if (AppletViewer.VERBOSE && value == null) {
			if ("force64mb".equals(name)) {
				System.out.println("Returning false for force64mb");
				return "false";
			}

			System.out.println("Unavailable param:" + name);
		}

		return value;
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getStreamKeys", descriptor = "()Ljava/util/Iterator;")
	@Override
	public Iterator getStreamKeys() {
		throw new UnsupportedOperationException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getDocumentBase", descriptor = "()Ljava/net/URL;")
	@Override
	public URL getDocumentBase() {
		try {
			return new URL(AppletViewer.getProperty("codebase"));
		} catch (@Pc(7) MalformedURLException ignored) {
			throw new InvalidParameterException();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getAudioClip", descriptor = "(Ljava/net/URL;)Ljava/applet/AudioClip;")
	@Override
	public AudioClip getAudioClip(@OriginalArg(0) URL url) {
		throw new UnsupportedOperationException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "isActive", descriptor = "()Z")
	@Override
	public boolean isActive() {
		return true;
	}

	@OriginalMember(owner = "jagexappletviewer!app/ba", name = "getStream", descriptor = "(Ljava/lang/String;)Ljava/io/InputStream;")
	@Override
	public InputStream getStream(@OriginalArg(0) String key) {
		throw new UnsupportedOperationException();
	}
}
