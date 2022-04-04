package com.transaticka.eccoinn.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class ModDoorBlock extends DoorBlock{

	public ModDoorBlock(Settings settings) {
		super(settings);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void appendProperties(Builder<Block, BlockState> builder) {
		// TODO Auto-generated method stub
		super.appendProperties(builder);
	}

	@Override
	public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
		// TODO Auto-generated method stub
		return super.canPathfindThrough(state, world, pos, type);
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		// TODO Auto-generated method stub
		return super.canPlaceAt(state, world, pos);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		// TODO Auto-generated method stub
		return super.getOutlineShape(state, world, pos, context);
	}

	@Override
	public PistonBehavior getPistonBehavior(BlockState state) {
		// TODO Auto-generated method stub
		return super.getPistonBehavior(state);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		// TODO Auto-generated method stub
		return super.getPlacementState(ctx);
	}

	@Override
	public long getRenderingSeed(BlockState state, BlockPos pos) {
		// TODO Auto-generated method stub
		return super.getRenderingSeed(state, pos);
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
			WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		// TODO Auto-generated method stub
		return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}

	@Override
	public boolean isOpen(BlockState state) {
		// TODO Auto-generated method stub
		return super.isOpen(state);
	}

	@Override
	public BlockState mirror(BlockState state, BlockMirror mirror) {
		// TODO Auto-generated method stub
		return super.mirror(state, mirror);
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos,
			boolean notify) {
		// TODO Auto-generated method stub
		super.neighborUpdate(state, world, pos, block, fromPos, notify);
	}

	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		// TODO Auto-generated method stub
		super.onBreak(world, pos, state, player);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		// TODO Auto-generated method stub
		super.onPlaced(world, pos, state, placer, itemStack);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		// TODO Auto-generated method stub
		return super.onUse(state, world, pos, player, hand, hit);
	}

	@Override
	public BlockState rotate(BlockState state, BlockRotation rotation) {
		// TODO Auto-generated method stub
		return super.rotate(state, rotation);
	}

	@Override
	public void setOpen(Entity entity, World world, BlockState state, BlockPos pos, boolean open) {
		// TODO Auto-generated method stub
		super.setOpen(entity, world, state, pos, open);
	}



}
