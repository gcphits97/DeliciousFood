package com.example.simplifyv2.deliciousfood.View;

public interface ViewDetail {
    void InsertSuccess();
    void InsertFail();
    void CheckLike(boolean checkLike, int countLike);
    void CheckShare(boolean checkShare, int countShare);
}
