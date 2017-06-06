package com.android.robust;

import android.content.Context;
import android.os.Environment;

import com.meituan.robust.Patch;
import com.meituan.robust.PatchManipulate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017/5/27.
 * BasicHealth
 */
public class PatchManpulateImpl extends PatchManipulate {

    @Override
    protected List<Patch> fetchPatchList(Context context) {
        Patch patch = new Patch();
        patch.setName("test robust...");
        patch.setLocalPath(Environment.getExternalStorageDirectory().getPath() + File.separator + "robust" + File.separator + "patch");
        patch.setTempPath(Environment.getExternalStorageDirectory().getPath() + File.separator + "robust" + File.separator + "patch");
        patch.setPatchesInfoImplClassFullName("com.android.robust.patch.PatchesInfoImpl");
        List<Patch> patches = new ArrayList<>(4);
        patches.add(patch);
        return patches;
    }

    @Override
    protected boolean verifyPatch(Context context, Patch patch) {
        return true;
    }

    @Override
    protected boolean ensurePatchExist(Patch patch) {
        return true;
    }
}
