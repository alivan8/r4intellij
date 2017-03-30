/*
 * Copyright 2011 Holger Brandl
 *
 * This code is licensed under BSD. For details see
 * http://www.opensource.org/licenses/bsd-license.php
 */

package com.r4intellij.interpreter;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.r4intellij.packages.RIndexCache;
import com.r4intellij.packages.RSkeletonGenerator;
import org.jetbrains.annotations.NotNull;

/**
 * @author Holger Brandl
 */
// from https://www.cqse.eu/en/blog/intellij-plugin-tutorial/
public class SkeletonUpdater implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        // This code is executed after the project was opened.

        RIndexCache.getInstance();
        ; //.loadSkeletonCache();
        RSkeletonGenerator.updateSkeletons(project);
    }
}