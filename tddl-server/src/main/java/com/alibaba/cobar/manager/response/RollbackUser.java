package com.alibaba.cobar.manager.response;

import com.alibaba.cobar.ErrorCode;
import com.alibaba.cobar.manager.ManagerConnection;
import com.alibaba.cobar.net.packet.OkPacket;

import com.taobao.tddl.common.utils.logger.Logger;
import com.taobao.tddl.common.utils.logger.LoggerFactory;

/**
 * @author xianmao.hexm
 */
public final class RollbackUser {

    private static final Logger logger = LoggerFactory.getLogger(RollbackUser.class);

    public static void execute(ManagerConnection c) {
        boolean status = false;
        if (status) {
            logger.warn("Rollback user success by manager");
            OkPacket ok = new OkPacket();
            ok.packetId = 1;
            ok.affectedRows = 1;
            ok.serverStatus = 2;
            ok.message = "Rollback user success".getBytes();
            ok.write(c);
        } else {
            c.writeErrMessage(ErrorCode.ER_YES, "Unsupported statement");
        }
    }

}
