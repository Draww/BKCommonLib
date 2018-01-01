package com.bergerkiller.bukkit.common.controller;

import net.minecraft.server.DamageSource;
import net.minecraft.server.Entity;

import org.bukkit.entity.HumanEntity;

import com.bergerkiller.bukkit.common.entity.nms.NMSEntityHook;
import com.bergerkiller.bukkit.common.internal.CommonNMS;

/**
 * Does nothing but redirect to the default entity behavior
 */
@SuppressWarnings("rawtypes")
public final class DefaultEntityController extends EntityController {

	public DefaultEntityController() {
	}

	@Override
	public void onDie() {
		final Object handle = entity.getHandle();
		if (handle instanceof NMSEntityHook) {
			super.onDie();
		} else {
//			((Entity) handle).isI
			((Entity) handle).die();
		}
	}

	@Override
	public void onTick() {
		final Object handle = entity.getHandle();
		if (handle instanceof NMSEntityHook) {
			super.onTick();
		} else {
			((Entity) handle).h();
		}
	}

	@Override
	public boolean onInteractBy(HumanEntity interacter) {
		final Object handle = entity.getHandle();
		if (handle instanceof NMSEntityHook) {
			return super.onInteractBy(interacter);
		} else {
			return ((Entity) handle).c(CommonNMS.getNative(interacter));
		}
	}

	@Override
	public void onDamage(com.bergerkiller.bukkit.common.wrappers.DamageSource damageSource, double damage) {
		if (entity.getHandle() instanceof NMSEntityHook) {
			super.onDamage(damageSource, damage);
		}
		((Entity) entity.getHandle()).damageEntity((DamageSource) damageSource.getHandle(), (float) damage);
	}

	@Override
	public String getLocalizedName() {
		final Object handle = entity.getHandle();
		if (handle instanceof NMSEntityHook) {
			return super.getLocalizedName();
		} else {
			return ((Entity) handle).getName();
		}
	}
	
	@Override
	public void onPush(double dx, double dy, double dz) {
		final Object handle = entity.getHandle();
		if (handle instanceof NMSEntityHook) {
			((NMSEntityHook) handle).super_g(dx, dy, dz);
		} else {
			((Entity) handle).g(dx, dy, dz);
		}
	}

	@Override
	public void onMove(double dx, double dy, double dz) {
		final Object handle = entity.getHandle();
		if (handle instanceof NMSEntityHook) {
			((NMSEntityHook) handle).super_move(dx, dy, dz);
		} else {
			((Entity) handle).move(dx, dy, dz);
		}
	}
}
