/*
 *  This file is part of Block IDLE.
 *
 *  Block IDLE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Block IDLE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Block IDLE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.icst.blockidle.api;

/**
 * Provides information about the Block IDLE plugin runtime environment.
 * <p>
 * This class exposes metadata about the host application that is running
 * the plugin, such as the application version and the supported plugin
 * API level. Plugin developers should rely on the {@link #getApiLevel()}
 * value for compatibility checks rather than comparing version names.
 * </p>
 *
 * <p>
 * This design mirrors Android's {@code android.os.Build.VERSION} system,
 * allowing plugins to adapt their behavior based on the runtime
 * capabilities provided by the host.
 * </p>
 *
 * <h3>Usage example:</h3>
 * <pre>{@code
 * PluginRuntimeInfo info = pluginApplication.getRuntimeInfo();
 * if (info.getApiLevel() >= 2) {
 *     // Safe to use API level 2 features
 * }
 * }</pre>
 */
public final class PluginRuntimeInfo {

	/**
	 * Human-readable version name of the host Block IDLE application.
	 * <p>
	 * This value is intended for display purposes only and should not
	 * be used for compatibility checks.
	 * </p>
	 */
	private final String versionName;

	/**
	 * Internal version code of the host Block IDLE application.
	 * <p>
	 * This value increases monotonically with each release and may be
	 * used for internal diagnostics or logging.
	 * </p>
	 */
	private final int versionCode;

	/**
	 * The plugin API level supported by the host runtime.
	 * <p>
	 * This is the primary value plugins should use to determine
	 * compatibility with the host application.
	 * </p>
	 */
	private final int apiLevel;

	/**
	 * Creates a new {@code PluginRuntimeInfo} instance.
	 *
	 * @param versionName the human-readable version name of the host application
	 * @param versionCode the internal version code of the host application
	 * @param apiLevel    the plugin API level supported by the host runtime
	 */
	public PluginRuntimeInfo(String versionName, int versionCode, int apiLevel) {
		this.versionName = versionName;
		this.versionCode = versionCode;
		this.apiLevel = apiLevel;
	}

	/**
	 * Returns the human-readable version name of the host application.
	 *
	 * @return the host application's version name
	 */
	public String getVersionName() {
		return versionName;
	}

	/**
	 * Returns the internal version code of the host application.
	 *
	 * @return the host application's version code
	 */
	public int getVersionCode() {
		return versionCode;
	}

	/**
	 * Returns the plugin API level supported by the host runtime.
	 * <p>
	 * Plugin developers should use this value to enable or disable
	 * features based on API availability.
	 * </p>
	 *
	 * @return the supported plugin API level
	 */
	public int getApiLevel() {
		return apiLevel;
	}
}
