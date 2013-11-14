/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iproxys.performblock.timers;

import iproxys.PersistenceData.TemporaryBlockedEntity;
import iproxys.performblock.PerformHttpBlock;
import iproxys.performblock.PerformIPPortBlock;
import iproxys.performblock.PerformIpBlock;
import iproxys.performblock.PerformPortBlock;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author root
 */
public class PerformUnblockOnTemporaryEntities extends TimerTask {

    @Override
    public void run() {
        TemporaryBlockedEntity blockedEntities = new TemporaryBlockedEntity();
        ArrayList<TemporaryBlockedEntity> unblockCandidates = blockedEntities.findEntityToUnblock();
        for (TemporaryBlockedEntity blockedEntity : unblockCandidates) {
            switch (blockedEntity.getIdentifier()) {

                case TemporaryBlockedEntity.BLOCK_IP:
                    PerformIpBlock performIpBlock = new PerformIpBlock(blockedEntity);
                    performIpBlock.unBlock();
                    break;
                case TemporaryBlockedEntity.BLOCK_IP_AND_PORT:
                    PerformIPPortBlock performIPPortBlock = new PerformIPPortBlock(blockedEntity);
                    performIPPortBlock.unBlock();
                    break;
                case TemporaryBlockedEntity.BLOCK_PORT:
                   PerformPortBlock performPortBlock = new PerformPortBlock(blockedEntity);
                   performPortBlock.unBlock();
                    break;
                case TemporaryBlockedEntity.BLOCK_HTTP_DOMAIN_TO_IP:
                    PerformHttpBlock performHttpBlock = new PerformHttpBlock(blockedEntity);
                    performHttpBlock.unBlock();
                    break;
            }
        }
    }
}
