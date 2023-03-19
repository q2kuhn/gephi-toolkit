/*
 * Copyright 2008-2023 Gephi
 * Website : https://gephi.org/
 *
 * This file is part of Gephi.
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 3 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * https://gephi.org/developers/license/
 * or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License files at
 * /cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 3, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 3] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 3 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 3 code and therefore, elected the GPL
 * Version 3 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Portions Copyrighted 2023 Gephi
 */
package org.gephi.toolkit;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.gephi.appearance.api.AppearanceController;
import org.gephi.filters.api.FilterController;
import org.gephi.graph.api.GraphController;
import org.gephi.io.exporter.api.ExportController;
import org.gephi.io.importer.api.ImportController;
import org.gephi.preview.api.PreviewController;
import org.gephi.project.api.ProjectController;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;

public abstract class ToolkitTest {

    protected final ProjectController projectController = Lookup.getDefault().lookup(ProjectController.class);

    protected final GraphController graphController = Lookup.getDefault().lookup(GraphController.class);

    protected final AppearanceController appearanceController = Lookup.getDefault().lookup(AppearanceController.class);

    protected final FilterController filterController = Lookup.getDefault().lookup(FilterController.class);

    protected final ImportController importController = Lookup.getDefault().lookup(ImportController.class);

    protected final ExportController exportController = Lookup.getDefault().lookup(ExportController.class);

    protected final PreviewController previewController = Lookup.getDefault().lookup(PreviewController.class);

    // Utilities

    protected File copyResourcesToTempDir(String fileName, File tempFolder) throws IOException {
        File file;
        try {
            file = new File(getClass().getResource("/org/gephi/toolkit/" + fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
        return FileUtil.toFile(
            FileUtil.copyFile(FileUtil.toFileObject(file), FileUtil.toFileObject(tempFolder), fileName));
    }
}
